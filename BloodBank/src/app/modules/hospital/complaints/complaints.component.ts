import { ComplaintDTO } from './../model/complaintDTO';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RegisterComplaintService } from '../services/complaint.service';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-complaints',
  templateUrl: './complaints.component.html',
  styleUrls: ['./complaints.component.css']
})
export class ComplaintsComponent implements OnInit {

  public complaints: ComplaintDTO[] = [];
  public currentPageID: number = 0;
  public pageID = 0;
  public selected: ComplaintDTO = new ComplaintDTO();
  public buttonSave = "Save";
  public buttonSaved = "Saved";
  public buttonText = this.buttonSave;

  public buttonForm: any;

  constructor(private registerComplaintService : RegisterComplaintService, private router: Router) { }

  ngOnInit(): void {
    this.buttonForm = new FormGroup({
      answer: new FormControl(this.selected.answer, [
        Validators.required,
        Validators.minLength(5),
      ]),
      complaint: new FormControl(this.selected.answer, [
        Validators.required,
        Validators.minLength(5),
      ]),
    });
    this.registerComplaintService.getAllByPageToAnswer(this.currentPageID).subscribe(res => {
      this.complaints = res;
    })
  }

  select(complaintID: number){
    this.buttonText = this.buttonSave;
    this.complaints.forEach(c => {
      if(c.id == complaintID)
      this.selected = c;
    });
    this.buttonForm.complaint = this.selected.complaint;
  }

  save(){
    this.registerComplaintService.postAnswer(this.selected).subscribe(res => {
      this.registerComplaintService.getAllByPageToAnswer(this.currentPageID).subscribe(res => {
        this.complaints = res;
      })
      this.buttonText = this.buttonSaved;
    })
  }

  backToHomePage(){
    this.router.navigate(['/home']);
  }

  previous(){
    this.pageID -= 1;
    this.checkValid();
    this.registerComplaintService.getAllByPageToAnswer(this.currentPageID).subscribe(res => {
      this.complaints = res;
    })
  }

  next(){
    this.pageID += 1;
    this.checkValid();
    this.registerComplaintService.getAllByPageToAnswer(this.currentPageID).subscribe(res => {
      this.complaints = res;
    })
  }

  checkValid(){
    if(this.pageID == null || this.pageID <= 0) this.pageID = 0
    this.currentPageID = this.pageID;
  }
}
