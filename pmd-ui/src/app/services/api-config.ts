export class ApiConfig 
{    
    private MOCK_BASE_URL = "http://localhost:4200/assets/mock/contracts.json";

    private BASE_URL = "http://localhost:8680";

    getApiUrl(url: string) {
        return `${this.BASE_URL}${url}`;
    }
}