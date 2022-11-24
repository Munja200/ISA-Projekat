import { Address } from "./address";

export class CenterDTO {
    id: number;
    name: string;
    address: Address;
    description: string;
    averageRating: number;
    deleted: boolean;

    public constructor(
        id: number = 0, 
        name: string = "",
        address: Address = new Address(), 
        description: string = "",
        averageRating: number = 0, 
        deleted: boolean = false
    ) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.description = description;
        this.averageRating = averageRating;
        this.deleted = deleted;
    }
}