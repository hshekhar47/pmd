import { Injectable } from '@angular/core';
import { PMDVersionService } from './index';
import { Subject } from 'rxjs/Subject';

@Injectable()
export class PMDAppService {
    private versionSubject = new Subject<String>();
    version = this.versionSubject.asObservable();
    private activeVersion = "v1";

    constructor(){}

    changeVersion(version: string) {
        console.log(`Activating version ${version}`);
        this.activeVersion = version;
        this.versionSubject.next(version);
    }

    getActiveVersion() { return this.activeVersion;}
}