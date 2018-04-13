import { Period } from './period.model';

export class ProductAttribute {
    gid:                    string;
    name:                   string;
    dataType:               string;
    required:               boolean;
}

export class ProductState 
{
    gid:                    string;
    name:                   string;
    description:            string;
    period:                 Period;
    productTypeAttributes:  ProductAttribute[];
}

export class Product 
{
    gid:                    string;
    code:                   string;
    versions:               any[];
}