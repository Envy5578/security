ALTER TABLE tokens
ADD COLUMN revoke_token boolean not null default false;
