export class Address {
    id: number = 0;
    deleted: boolean = false;
    name: string = '';
    address: Address;
    description: string = '';
    averageRating: number = 0.0;

    public constructor(obj?:any ) {
        this.id = obj.id;
        this.name = obj.name;
        this.description = obj.description;
        this.averageRating = obj.averageRating;
        this.address = obj.address;
    }
}