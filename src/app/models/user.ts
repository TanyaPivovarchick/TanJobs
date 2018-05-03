export class User {

    id?: string;
    email: string;
    password: string;
    firstName: string;
    lastName: string;

    public static isNull(user: User): boolean {
        return user.email === null &&
            user.password === null &&
            user.firstName === null &&
            user.lastName === null;
    }
}
