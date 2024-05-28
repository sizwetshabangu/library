import { Module } from '@nestjs/common';
import { AddressService } from './address.service';
import { AddressController } from './address.controller';
import { DatabaseModule } from 'src/provider/database/database.module';
import { addressProvider } from './address.provider';

@Module({
  imports: [DatabaseModule],
  controllers: [AddressController],
  providers: [...addressProvider, AddressService],
})
export class AddressModule { }
