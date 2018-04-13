import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { catchError } from 'rxjs/operators';
import { ApiConfig } from './index';

@Injectable()
export class PMDProductService extends ApiConfig
{
    constructor(private httpClient: HttpClient) { 
        super();
    }
    
    getAll(version: string, page:number = 0, records: number = 10) {
        let apiUrl = this.getApiUrl(`/api/pmd/${version}/products`)
        console.log(`GET ${apiUrl}`);
        return this.httpClient.get(apiUrl);
    }

    getOneById(version: string, id: number) {
        let apiUrl = this.getApiUrl(`/api/pmd/${version}/products/${id}`)
        console.log(`GET ${apiUrl}`);
        return this.httpClient.get(apiUrl);
    }
}