import { Logger, Module } from '@nestjs/common';
import { StaffService } from './staff.service';
import { StaffController } from './staff.controller';
import { DatabaseModule } from 'src/database/database.module';
import { staffProvider } from './staff.provider';

@Module({
  imports: [DatabaseModule],
  controllers: [StaffController],
  providers: [...staffProvider, StaffService, Logger],
})
export class StaffModule { }
