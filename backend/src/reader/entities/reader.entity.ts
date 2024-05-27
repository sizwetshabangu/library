export class Reader {
    constructor(
        private id: string,
        private firstName: string,
        private lastName: string,
        private email: string,
        private phone: string,
        private address: string,
        private createdAt: Date,
        private updatedAt: Date,
        private deletedAt: Date,
        private deleted: boolean,
        private deletedBy: string,
        private updatedBy: string,
        private createdBy: string,
    ) { }
}
