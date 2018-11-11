ALTER TABLE `client`
  ADD UNIQUE (`email`);
ALTER TABLE `developer`
  ADD UNIQUE (`email`);
ALTER TABLE `usrs`
  ADD UNIQUE (`email`);