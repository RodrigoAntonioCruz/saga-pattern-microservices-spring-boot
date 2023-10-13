
db1 = db.getSiblingDB('inventory');

db1.createCollection('inventories');

db1.inventories.insertMany([{
                         _id: ObjectId("648f0e708216534e611ecbe1"),
                         "productId": "648f0e708216534e611ecbe1",
                         "quantity": 8,
                         "_class": "com.inventory.adapters.out.repository.entity.InventoryEntity"
                      },{
                        _id: ObjectId("648f0e9a8216534e611ecbe4"),
                        "productId": "648f0e9a8216534e611ecbe4",
                        "quantity": 3,
                        "_class": "com.inventory.adapters.out.repository.entity.InventoryEntity"
                      }]);

db2 = db.getSiblingDB('payment');

db2.createCollection('users');

db2.users.insertMany([{
                         _id: ObjectId("648f0e398216534e611ecbdb"),
                         "name": "Juca Batista",
                         "balance": "20.00",
                         "_class": "com.payment.adapters.out.repository.mapper.entity.UserEntity"
                      },{
                        _id: ObjectId("648f0e568216534e611ecbdf"),
                        "name": "Mario Souto",
                        "balance": "40.00",
                        "_class": "com.payment.adapters.out.repository.mapper.entity.UserEntity"
                      }]);

db3 = db.getSiblingDB('payment');

db3.createCollection('payments');

db3.payments.insertMany([{
                         _id: ObjectId("64db5b10d374b874394dde07"),
                         "userId": "648f0e398216534e611ecbdb",
                         "saleId": "64db5b0f5b23cb57036396c4",
                         "value": "15.00",
                         "_class": "com.arantes.payment.adapters.out.repository.mapper.entity.PaymentEntity"
                      },{
                        _id: ObjectId("64db5b65d374b874394dde08"),
                         "userId": "648f0e398216534e611ecbdb",
                         "saleId": "64db5b0f5b23cb57036396c4",
                         "value": "16.00",
                         "_class": "com.arantes.payment.adapters.out.repository.mapper.entity.PaymentEntity"
                      },{
                        _id: ObjectId("64db5bb5d374b874394dde09"),
                         "userId": "648f0e398216534e611ecbdb",
                         "saleId": "64db5bb22775be4488858995",
                         "value": "25.00",
                         "_class": "com.arantes.payment.adapters.out.repository.mapper.entity.PaymentEntity"
                      },{
                        _id: ObjectId("64db5c53d374b874394dde0a"),
                         "userId": "648f0e398216534e611ecbdb",
                         "saleId": "64db5c532775be4488858997",
                         "value": "8.00",
                         "_class": "com.arantes.payment.adapters.out.repository.mapper.entity.PaymentEntity"
                      },{
                        _id: ObjectId("64e10fcc07786543817be207"),
                         "userId": "648f0e568216534e611ecbdf",
                         "saleId": "64e10fcbaf5009753a1afc42",
                         "value": "15.00",
                         "_class": "com.arantes.payment.adapters.out.repository.mapper.entity.PaymentEntity"
                      },{
                        _id: ObjectId("64e1136707786543817be208"),
                         "userId": "648f0e568216534e611ecbdf",
                         "saleId": "64e11367af5009753a1afc43",
                         "value": "18.00",
                         "_class": "com.arantes.payment.adapters.out.repository.mapper.entity.PaymentEntity"
                      }]);