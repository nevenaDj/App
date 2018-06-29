import { Departman } from "./departman";
import { User } from "./user";

export class Professor implements ProfessorInterface {
    public id: number;
    public user: User
    public departman: Departman;
   	
	constructor(stdCfg: ProfessorInterface)
	{	
        this.id = stdCfg.id;
        this.user = stdCfg.user;
        this.departman = stdCfg.departman;
	}
}


interface ProfessorInterface{
    id: number;
    user: User;
    departman: Departman;
}