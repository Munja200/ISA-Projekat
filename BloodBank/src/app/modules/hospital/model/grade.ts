export class Grade {
    id: number = 0;
    personId : number = 0;
    centerId : number = 0;
    score: number = 0.0;

    constructor(obj?: any) {
        if (obj) {
          this.id = obj.id;
          this.personId = obj.personId;
          this.centerId = obj.centerId;
          this.score = obj.score;
        }
      }
}