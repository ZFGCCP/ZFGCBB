alter table zfgbb.board
add column parent_board_id integer references zfgbb.board;