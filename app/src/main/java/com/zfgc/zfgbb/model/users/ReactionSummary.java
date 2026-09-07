package com.zfgc.zfgbb.model.users;

import lombok.Data;

@Data
public class ReactionSummary {
	private Integer reputationPoints;
	private Integer positiveCount;
	private Integer negativeCount;
	private Integer reactionCount;
}
