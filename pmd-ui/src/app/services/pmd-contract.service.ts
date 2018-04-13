import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { catchError } from 'rxjs/operators';

@Injectable()
export class PMDContractService {
    constructor(private httpClient: HttpClient) { }
    
    getAll(page:number = 0, records: number = 10) {
        let apiUrl = "http://localhost:4200/assets/mocks/contracts.json";
        console.log(`GET ${apiUrl}`);
        return this.httpClient.get(apiUrl);
    }

    getOneById(id: number) {
        let apiUrl = "http://localhost:4200/assets/mocks/contract.json";
        console.log(`GET ${apiUrl}`);
        return this.httpClient.get(apiUrl);
    }
}