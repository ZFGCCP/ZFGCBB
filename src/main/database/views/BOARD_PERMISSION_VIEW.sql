create or replace view board_permission_view as
select b.board_id,
       p.permission_id,
       p.permission_code,
       p.permission_name
from zfgbb.br_board_permission br
join zfgbb.permission p on p.permission_id = br.permission_id
join zfgbb.board b on b.board_id = br.board_id