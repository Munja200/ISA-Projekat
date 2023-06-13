
export class Blood {
    id: number;
    quantity: string;
    bloodType: string;
    centerId : number;

    public constructor(
        id: number = 0,
        quantity: string = '',
        bloodType: string = '',
        centerId: number = 0
    ) {
        this.id = id;
        this.quantity = quantity;
        this.bloodType = bloodType;
        this.centerId = centerId
    }
}