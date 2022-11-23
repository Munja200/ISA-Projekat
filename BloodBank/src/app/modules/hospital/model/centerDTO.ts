import { Address } from "./address";

export class CenterDTO {
    id: number ;
    deleted: boolean=false;
    name: string ;
    address: Address;
    description: string ;
    averageRating: string;

    public constructor(id: any,
        deleted: any,
        name: any,
        address: any,
        description: any,
        averageRating: any ) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.averageRating = averageRating;
        this.address = address;
    }
}