import { Period } from "./index";

export class PMDVersion  {
    gid:        number;
    code:       string;
    period:     Period;
    nextId?:    number;
    links?:      any;
}