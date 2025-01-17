create or replace function zfgbb.create_bbcode_config(p_bbcode_config_id int, p_bbcode text, p_end_tag text, p_process_content boolean) 
returns void
language plpgsql
as $$

begin

	insert into zfgbb.bb_code_config(bb_code_config_id, code, end_tag, process_content_flag)
	values(p_bbcode_config_id, p_bbcode, p_end_tag, p_process_content)
	on conflict (bb_code_config_id)
	do update set code = p_bbcode, end_tag = p_end_tag, process_content_flag = p_process_content,updated_ts = current_timestamp;
	
	return;
	
end; $$;

create or replace function zfgbb.create_bbcode_attr_mode(p_attr_mode_id int, p_bbcode text, p_open_tag text, p_close_tag text, p_content_attr_flag boolean, p_output_content_flag boolean)
returns void
language plpgsql
as $$
declare
	bbcode_id int;
begin
	bbcode_id := (select bb_code_config_id 
				 from zfgbb.bb_code_config
	             where code = p_bbcode);
	            
	insert into zfgbb.bb_code_attribute_mode(bb_code_attribute_mode_id, bb_code_config_id, content_is_attribute_flag, open_tag, close_tag, output_content_flag)
	values(p_attr_mode_id, bbcode_id, p_content_attr_flag, p_open_tag, p_close_tag, p_output_content_flag)
	on conflict (bb_code_attribute_mode_id)
	do update set bb_code_config_id = bbcode_id, 
				  content_is_attribute_flag = p_content_attr_flag, 
				  open_tag = p_open_tag, 
				  close_tag = p_close_tag, 
				  output_content_flag = p_output_content_flag, 
				  updated_ts = current_timestamp;
				  
	return;

end; $$;

create or replace function zfgbb.create_bbcode_attr(p_bb_code_attr_id int, p_attr_index int, p_bb_code_mode_id int, p_attr_name text, p_attr_type int)
returns void
language plpgsql
as $$
begin
	
	insert into zfgbb.bb_code_attribute(bb_code_attribute_id, attribute_index, bb_code_attribute_mode_id, name, attribute_data_type)
	values(p_bb_code_attr_id, p_attr_index, p_bb_code_mode_id, p_attr_name, p_attr_type)
	on conflict (bb_code_attribute_id)
	do update set attribute_index = p_attr_index, 
				  bb_code_attribute_mode_id = p_bb_code_mode_id, 
				  name = p_attr_name,
				  attribute_data_type = p_attr_type,
				  updated_ts = current_timestamp;
	
end; $$;

--base configurations
select zfgbb.create_bbcode_config(1, 'b', '</span>', true);
select zfgbb.create_bbcode_config(2, 'u', '</span>', true);
select zfgbb.create_bbcode_config(3, 'i', '</span>', true);
select zfgbb.create_bbcode_config(4, 's', '</span>', true);
select zfgbb.create_bbcode_config(5, 'pre', '</pre>', true);
select zfgbb.create_bbcode_config(6, 'left', '</span>', true);
select zfgbb.create_bbcode_config(7, 'center', '</span>', true);
select zfgbb.create_bbcode_config(8, 'right', '</span>', true);
select zfgbb.create_bbcode_config(9, 'youtube', '</span>', false);
select zfgbb.create_bbcode_config(10, 'spoiler', '</span>', true);
select zfgbb.create_bbcode_config(11, 'img', '</span>', false);
select zfgbb.create_bbcode_config(12, 'url', '</a></span>', true);
select zfgbb.create_bbcode_config(13, 'email', '</span>', false);
select zfgbb.create_bbcode_config(14, 'ftp', '</span>', false);
select zfgbb.create_bbcode_config(15, 'move', '</marquee>', true);
select zfgbb.create_bbcode_config(16, 'black', '</span>', true);
select zfgbb.create_bbcode_config(17, 'blue', '</span>', true);
select zfgbb.create_bbcode_config(18, 'quote', '</div></div>', true);
select zfgbb.create_bbcode_config(19, 'code', '</span>', true);
select zfgbb.create_bbcode_config(20, 'color', '</span>', true);
select zfgbb.create_bbcode_config(21, 'green', '</span>', true);

--attribute modes
--add at least one attribute mode for each bbcode
--an attribute mode configures which set of attributes will function for a bbcode
--most will probably just have one mode that doesn't take the content as a passive attribute
--id, bbcode, opentag, closetag, content attr flag, output content flag
select zfgbb.create_bbcode_attr_mode(1,'b','<span class="bb-code-b">','</span>',false,false);
select zfgbb.create_bbcode_attr_mode(2,'u','<span class="bb-code-u">','</span>',false,false);
select zfgbb.create_bbcode_attr_mode(3,'i','<span class="bb-code-i">','</span>',false,false);
select zfgbb.create_bbcode_attr_mode(4,'pre','<pre>','</pre>',false,false);
select zfgbb.create_bbcode_attr_mode(5,'left','<div class="bb-code-left">','</div>',false,false);
select zfgbb.create_bbcode_attr_mode(6,'center','<div class="bb-code-center">','</div>',false,false);
select zfgbb.create_bbcode_attr_mode(7,'right','<div class="bb-code-right">','</div>',false,false);

select zfgbb.create_bbcode_attr_mode(8,'youtube','<div class="bb-code-youtube"><iframe width="640" height="480" src="https://www.youtube.com/embed/{{c}}" frameborder="0" allow="encrypted-media" allowfullscreen> ','</iframe></div>',true,false);
select zfgbb.create_bbcode_attr(1, 0, 8, 'NAMELESS', 1);

select zfgbb.create_bbcode_attr_mode(9,'spoiler','<span class="bb-code-spoiler">','</span>',false,false);
select zfgbb.create_bbcode_attr_mode(10,'img','<span class="bb-code-img"><img src="{{c}}"/>','</span>',true,false);
select zfgbb.create_bbcode_attr_mode(12,'url','<span class="bb-code-url"><a href="{{0}}">','</a></span>',false,false);
select zfgbb.create_bbcode_attr(3, 0, 12, 'NAMELESS', 1);

select zfgbb.create_bbcode_attr_mode(13,'email','<span class="bb-code-email"><a href="mailto:{{0}}">','</a></span>',false,false);
select zfgbb.create_bbcode_attr_mode(14,'ftp','<span class="bb-code-ftp"><a href="{{0}}">','</a></span>',false,false);
select zfgbb.create_bbcode_attr_mode(15,'move','<marquee>','</marquee>',false,false);
select zfgbb.create_bbcode_attr_mode(16,'black','<span style="color:black">','</span>',false,false);
select zfgbb.create_bbcode_attr_mode(16,'blue','<span style="color:blue">','</span>',false,false);

select zfgbb.create_bbcode_attr_mode(17,'quote','<div class="bb-code-quote"><div class="bb-code-quote-body">','</div></div>',false,false);

select zfgbb.create_bbcode_attr_mode(18,'quote','<div class="bb-code-quote"><div class="bb-code-quote-header">Quote from {{0}},</div><div class="bb-code-quote-body">','</div></div>',false,false);
select zfgbb.create_bbcode_attr(2, 0, 18, 'author', 1);

select zfgbb.create_bbcode_attr_mode(21,'quote','<div class="bb-code-quote"><div class="bb-code-quote-header">Quote from {{0}} on {{2}}</div><div class="bb-code-quote-body">','</div></div>',false,false);
select zfgbb.create_bbcode_attr(4, 0, 21, 'author', 1);
select zfgbb.create_bbcode_attr(5, 1, 21, 'link', 1);
select zfgbb.create_bbcode_attr(6, 2, 21, 'date', 0);

select zfgbb.create_bbcode_attr_mode(19,'color','<span style="color:{{0}}">','</span>',false,false);
select zfgbb.create_bbcode_attr_mode(20,'green','<span style="color:green">','</span>',false,false);