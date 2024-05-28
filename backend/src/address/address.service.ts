import { Inject, Injectable } from '@nestjs/common';
import { CreateAddressDto } from './dto/create-address.dto';
import { UpdateAddressDto } from './dto/update-address.dto';
import { ADDRESS_REPOSITORY } from '../common/constants';
import { Repository } from 'typeorm';
import { Address } from './entities/address.entity';

@Injectable()
export class AddressService {
  constructor(@Inject(ADDRESS_REPOSITORY) private adressRepository: Repository<Address>) { }
  create(createAddressDto: CreateAddressDto) {
    return 'This action adds a new address';
  }

  async findAll(): Promise<Address[]> {
    return this.adressRepository.find();
  }

  findOne(id: number) {
    return `This action returns a #${id} address`;
  }

  update(id: number, updateAddressDto: UpdateAddressDto) {
    return `This action updates a #${id} address`;
  }

  remove(id: number) {
    return `This action removes a #${id} address`;
  }
}
