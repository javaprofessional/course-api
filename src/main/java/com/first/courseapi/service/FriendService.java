package com.first.courseapi.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.first.courseapi.model.Friend;

@Service
public class FriendService {
	List<Friend> friendList = new ArrayList<>();

	public List<Friend> addingFriend(JsonNode jsonnode) {
		Date date = null;
		SimpleDateFormat convert = new SimpleDateFormat("yyyy-MM-dd");
		try {
			date = convert.parse(jsonnode.get("dateofbirth").asText());

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Friend friend = new Friend(jsonnode.get("name").asText(), date, jsonnode.get("gender").asText(),
				jsonnode.get("zipcode").asLong());
		friendList.add(friend);
		return (friendList);

	}

	public List<Friend> genderSearching(String gender) {
		List<Friend> genderList = new ArrayList<>();
		for (Friend friend : friendList) {
			if (friend.getGender().equalsIgnoreCase(gender)) {
				genderList.add(friend);

			}
		}
		return genderList;

	}

	@SuppressWarnings("deprecation")
	public int calculatingAge(String name) {
		int years =0;
		for (Friend friend : friendList) {
			Date dateofbirth2 = friend.getDateofbirth();
			int year = dateofbirth2.getYear()+1900;
			System.out.println("year in dob---"+year);
			int month = dateofbirth2.getMonth();
			int day = dateofbirth2.getDay();
			LocalDate birthDate = LocalDate.of(year, month, day);
			Period between = Period.between( birthDate,LocalDate.now());
			System.out.println("between--->"+between.getYears());
			years = between.getYears();
			System.out.println("month---"+between.getMonths());
			System.out.println("Days----"+between.getDays());
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

		}
		return (years);
	}

}
