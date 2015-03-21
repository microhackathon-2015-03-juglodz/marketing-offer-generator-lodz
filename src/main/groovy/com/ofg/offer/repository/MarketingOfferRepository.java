package com.ofg.offer.repository;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.ofg.offer.dto.MarketingOffer;
import com.ofg.offer.dto.Person;


@Service
@Scope("singleton")
public class MarketingOfferRepository {

	Map<Person, MarketingOffer> markettingOffers = new HashMap<Person, MarketingOffer>();
	// @Autowired
	// private RedisTemplate<String, String> template;
	
	public MarketingOffer getMarketingOffer(Person person){
		System.out.println("Offers: " + markettingOffers.keySet());
		return markettingOffers.get(person);
	}
	
	public void putMarketingOffer(Person person, MarketingOffer offer){
		markettingOffers.put(person, offer);
	}
	
}
