create or replace function zfgbb.create_content_types(content_type_id int, code text, p_description text) 
returns void
language plpgsql
as $$
begin
	
	insert into zfgbb.content_resource_type(content_resource_type_id, content_code, description)
	values(content_type_id, code, p_description)
	on conflict (content_resource_type_id)
	do update set content_code = code, description = p_description;
	
	return;
	
end; $$;

select zfgbb.create_content_types(1, 'AVR', 'Avatar');
select zfgbb.create_content_types(2, 'ATC', 'Attachment');

create or replace function zfgbb.create_gender_lkup(
    p_code text,
    p_description text,
    p_seqno integer
) returns void as $$
begin
    insert into zfgbb.gender_lkup (code, description, seqno)
    values (p_code, p_description, p_seqno)
    on conflict (upper(code))
    do update
    set
        description = excluded.description,
        seqno = excluded.seqno,
        updated_ts = current_timestamp;
end;
$$ language plpgsql;

select zfgbb.create_gender_lkup('M', 'Male', 0);
select zfgbb.create_gender_lkup('F', 'Female', 1);
select zfgbb.create_gender_lkup('NB', 'Non-Binary', 2);
select zfgbb.create_gender_lkup('NA', 'Other/Prefer not to say', 3);

create or replace function zfgbb.create_smiley_set(
    p_code text,
    p_label text,
    p_ordinal integer
) returns void as $$
begin
    insert into zfgbb.smiley_set (code, label, ordinal)
    values (p_code, p_label, p_ordinal)
    on conflict (code)
    do update
    set
        label = excluded.label,
        ordinal = excluded.ordinal,
        updated_ts = current_timestamp;
end;
$$ language plpgsql;

select zfgbb.create_smiley_set('TPLINK', 'TP Link', 0);
select zfgbb.create_smiley_set('TAKAM', 'TakaM', 1);
select zfgbb.create_smiley_set('CLASSIC', 'Classic', 2);
select zfgbb.create_smiley_set('NONE', 'None', 3);

create or replace function zfgbb.create_smiley(
    p_code text,
    p_name text,
    p_label text,
    p_ordinal integer
) returns void as $$
begin
    insert into zfgbb.smiley (code, name, label, ordinal)
    values (p_code, p_name, p_label, p_ordinal)
    on conflict (code)
    do update
    set
        name = excluded.name,
        label = excluded.label,
        ordinal = excluded.ordinal,
        updated_ts = current_timestamp;
end;
$$ language plpgsql;

select zfgbb.create_smiley(':)', 'smiley', 'Smiley', 0);
select zfgbb.create_smiley(';)', 'wink', 'Ouch, you poked my eye out!', 1);
select zfgbb.create_smiley(':D', 'cheesy', 'Cheesy', 2);
select zfgbb.create_smiley('XD', 'grin', 'Grin', 3);
select zfgbb.create_smiley(':(', 'sad', 'Emo-Kid? Where!?', 4);
select zfgbb.create_smiley(':o', 'shocked', 'Holy Fu-', 5);
select zfgbb.create_smiley('8)', 'cool', 'Cool', 6);
select zfgbb.create_smiley(':huh:', 'huh', 'WTF! Are you talking about?', 7);
select zfgbb.create_smiley('::)', 'rolleyes', 'Roll Eyes', 8);
select zfgbb.create_smiley(':P', 'tongue', 'Look at me, I''m invisible!', 9);
select zfgbb.create_smiley(':-[', 'embarrassed', 'Embarrassed', 10);
select zfgbb.create_smiley(':-X', 'lipsrsealed', 'Lips Sealed', 11);
select zfgbb.create_smiley(':-\', 'undecided', 'Undecided', 12);
select zfgbb.create_smiley(':-*', 'kiss', 'Kiss', 13);
select zfgbb.create_smiley(':''(', 'cry', 'Emo-Kid? Where!?', 14);
select zfgbb.create_smiley('>:(', 'angry', 'Grrr', 15);
select zfgbb.create_smiley('>:D', 'evil', 'Evil', 16);
select zfgbb.create_smiley('>:)', 'evil', 'Evil', 17);
