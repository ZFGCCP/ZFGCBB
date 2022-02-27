SELECT u.user_id,
       p.permission_id,
       p.permission_code
FROM zfgbb.br_user_permission u
JOIN zfgbb.permission p ON p.permission_id = u.user_permission_id