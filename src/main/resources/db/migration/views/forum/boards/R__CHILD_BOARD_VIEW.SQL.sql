create or replace view zfgbb.child_board_view as
select board.board_id, board.board_name, board.parent_board_id
from zfgbb.board
where parent_board_id is not null