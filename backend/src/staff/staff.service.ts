import { Injectable, Logger } from '@nestjs/common';
import { CreateStaffDto } from './dto/create-staff.dto';
import { UpdateStaffDto } from './dto/update-staff.dto';
import { Repository } from 'typeorm';
import { Staff } from './entities/staff.entity';
import { UUID } from 'crypto';
import { InjectRepository } from '@nestjs/typeorm';

@Injectable()
export class StaffService {
  constructor(
    @InjectRepository(Staff) private staffRepository: Repository<Staff>,
    private Logger: Logger
  ) { };

  create(createStaffDto: CreateStaffDto) {
    return this.staffRepository.save(createStaffDto);
  }

  findAll() {
    return this.staffRepository.find();
  }

  findOne(id: UUID) {
    return this.staffRepository.findOneBy({ id });
  }

  update(id: UUID, updateStaffDto: UpdateStaffDto) {

    return this.staffRepository.update(id, updateStaffDto);
  }

  remove(id: UUID) {
    return this.staffRepository.delete(id);
  }
}
