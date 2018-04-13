import { Component, OnInit, OnDestroy } from '@angular/core';
import { version } from 'punycode';
import { PMDVersion } from '../../../models/Version.model';

import { PMDVersionService } from '../../../services/index';
import { Subscription } from 'rxjs/Subscription';
import { PMDApiResponse } from '../../../models/index';
import { FormControl, Validators } from '@angular/forms';
import { PMDAppService } from '../../../services/pmd-app-service';

@Component({
    selector: 'pmd-version-picker',
    template: `
        <div class="version-picker m-l" *ngIf="versions">
            <mat-form-field>
                <mat-select [formControl]="vSelectionCtrl" (change)="onChange()">
                    <mat-option *ngFor="let version of versions" [value]="version.code">
                        Version {{ version.code }}
                    </mat-option>
                </mat-select>
            </mat-form-field>
        </div>
    `,
    styles: [`
        .version-picker {
            display: inline-flex;
        }
    `]
})
export class PMDVersionPickerComponent implements OnInit, OnDestroy {
    private activeVersion;
    private httpSubscription: Subscription;
    private versions: PMDVersion[] = [];
    private vSelectionCtrl = new FormControl(this.activeVersion, [Validators.required]);

    constructor(
        private appService: PMDAppService,
        private versionService: PMDVersionService
    ) { 
        this.appService.version.subscribe(
            version => {
                this.activeVersion = version;
            });
    }

    initializeVersion(version) {
        if(!this.activeVersion) {
            this.activeVersion = version;
            this.appService.changeVersion(this.activeVersion);
            this.vSelectionCtrl.setValue(version);
        }
    }
    
    ngOnInit() {
        this.httpSubscription = 
            this.versionService.getAll()
                .subscribe(
                    (response: PMDApiResponse) => {
                        this.versions = response.data;
                        let latestVersion = this.versions.filter(element => element.nextId == null)[0];
                        console.log(`Latest version is ${latestVersion.code}`);
                        this.initializeVersion(latestVersion.code);
                    },
                    (err) => {
                        console.log(err);
                    }
                );
    }

    ngOnDestroy() {
        if(this.httpSubscription) {
            this.httpSubscription.unsubscribe();
        }
    }

    onChange() {
        this.appService.changeVersion(this.vSelectionCtrl.value);
    }
}