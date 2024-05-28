export default () => ({
    host: process.env.DATABASE_HOST,
    type: process.env.MYSQL_DATABASE_TYPE,
    port: process.env.MYSQL_PORT,
    username: process.env.MYSQL_USER,
    password: process.env.MYSQL_PASSWORD,
    database: process.env.MYSQL_DATABASE,
    synchronize: process.env.TYPEORM_SYNCHRONIZE,
});