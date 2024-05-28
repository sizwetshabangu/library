export interface PublisherDto {
    id: string;
    name: string;
    createdAt: Date;
    updatedAt: Date;
    deletedAt: Date;
    deleted: boolean;
    deletedBy: string;
    updatedBy: string;
    createdBy: string;
}