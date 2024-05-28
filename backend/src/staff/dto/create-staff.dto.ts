export type CreateStaffDto = Omit<StaffDto, 'id' | 'createdAt' | 'updatedAt' | 'deleteBy' | 'createdBy' | 'updateBy'>;
