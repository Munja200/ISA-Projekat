import { Address } from "./address";

export class CenterDTO {
    id: number = 0;
    name: string;
    address: Address;
    description: string;
    averageRating: number;
    deleted: boolean = false;

    public constructor(id:any, name: any, address: any, description: any, averageRating: any, deleted: any) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.description = description;
        this.averageRating = averageRating;
        this.deleted = deleted;
    }
}