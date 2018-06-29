export class User implements UserInterface {
    public id: number;
    public firstName: string;
    public lastName: string;
    public username: string;
    public roles: string[];
   	
	constructor(stdCfg: UserInterface)
	{	
        this.id = stdCfg.id;
        this.firstName = stdCfg.firstName;
        this.lastName = stdCfg.lastName;
        this.username = stdCfg.username; 
        this.roles = stdCfg.roles;       
	}
}


interface UserInterface{
    id: number;
    firstName: string;
    lastName: string;
    username: string;
    roles: string[];
}