import { Subject } from "./subject";
import { User } from "./user";


export class Exam implements ExamInterface {
    public id: number;
    public rating: number;
    public subject: Subject;
    public user: User;
       
	constructor(stdCfg: ExamInterface)
	{	
        this.id = stdCfg.id;
        this.rating = stdCfg.rating;
        this.subject = stdCfg.subject;
        this.user = stdCfg.user;
    
    }
}


interface ExamInterface{
    id: number;
    rating: number;
    subject: Subject;
    user: User;
}