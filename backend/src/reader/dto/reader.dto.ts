import { UUID } from "crypto";

export interface ReaderDto {
    id: UUID,
    firstName: string,
    lastName: string,
    email: string,
    phone: string,
    address: string,
    createdAt: Date,
    updatedAt: Date,
    deletedAt: Date,
    deleted: boolean,
    deletedBy: string,
    updatedBy: string,
    createdBy: string,
}