import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { catchError } from 'rxjs/operators';
import { ApiConfig } from './index';

@Injectable()
export class PMDVersionService extends ApiConfig {

    constructor(private httpClient: HttpClient) {
        super()
    }

    getAll() {
        let apiUrl = this.getApiUrl("/api/pmd/versions");
        console.log(`GET ${apiUrl}`)
        return this.httpClient.get(apiUrl);
    }

    getOneById(id: number) {
        let apiUrl = this.getApiUrl("/api/pmd/versions/" + id);
        console.log(`GET ${apiUrl}`);
        return this.httpClient.get(apiUrl);
    }

    getOneByCode(code: string) {
        let apiUrl = this.getApiUrl("/api/pmd/versions/q?type=code&code=" + code);
        console.log(`GET ${apiUrl}`);
        return this.httpClient.get(apiUrl);
    }

    getLatestOne() {
        let apiUrl = this.getApiUrl("/api/pmd/versions/q?type=code&code=latest");
        console.log(`GET ${apiUrl}`);
        return this.httpClient.get(apiUrl);
    }

    getFirstOne() {
        let apiUrl = this.getApiUrl("/api/pmd/versions/q?type=code&code=oldest");
        console.log(`GET ${apiUrl}`);
        return this.httpClient.get(apiUrl);
    }
    
}