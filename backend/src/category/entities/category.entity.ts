export class Category {
    constructor(
        private id: string,
        private name: string,
        private description: string,
        private createdAt: Date,
        private updatedAt: Date,
        private deletedAt: Date,
        private deleted: boolean,
        private deletedBy: string,
        private updatedBy: string,
        private createdBy: string,
    ) { }
}
