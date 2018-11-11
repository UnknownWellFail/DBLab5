insert into usrs (id,username,password,active)
      value (1,'admin','$2a$08$30FW88TX2dC0wZ7/F0F.ieFtvgVEa8LTFsL2NkFxmstjh7Rliuzs2',true);

insert into user_role (user_id,roles)
        values (1,'USER'),(1,'ADMIN');