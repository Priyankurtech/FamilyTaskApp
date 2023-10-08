package com.family.controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.annotation.WebServlet;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import com.family.dao.TaskDao;

import lombok.var;


public class TaskBot extends TelegramLongPollingBot{
	private boolean screaming = false;
	private InlineKeyboardMarkup keyboardM1;
	private InlineKeyboardMarkup keyboardM2;
	
	@Override
	public void onUpdateReceived(Update update) {
		
		User user=update.getMessage().getFrom();
		String text=update.getMessage().getText();
		System.out.println(text);
		if (text.equals("/grocery_details")) {
			sendText(user.getId(), "ggggg");
		} else if(text.equals("/event_details")){
			try {
				
				TaskDao dao = new TaskDao();
				String query = "select * from familyevent";
				Connection con = dao.connect_to_database();
				Statement statement = con.createStatement();
				ResultSet resultSet = statement.executeQuery(query);
				while (resultSet.next()) {
					
					String taskname = resultSet.getString("task_name");
					String taskd = resultSet.getString("task_details");
					String status = resultSet.getString("status");
					Date startdate =resultSet.getDate("event_start_date") ;
					Date enddate =resultSet.getDate("event_end_date");
					sendText(user.getId(), "taskname= "+taskname+" taskdescription= "+taskd+" taskstatus= "+status+" startdate= "+startdate+" enddate= "+enddate);
				}
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
			InlineKeyboardButton next = InlineKeyboardButton.builder()
		            .text("Next").callbackData("next")           
		            .build();

		 InlineKeyboardButton back = InlineKeyboardButton.builder()
		            .text("Back").callbackData("back")
		            .build();
		 
		 
		}
		else
		{
			sendText(user.getId(), "thank you for using our bot ❤️.How can I help You");
		}
		
	}

	@Override
	public String getBotUsername() {
		// TODO Auto-generated method stub
		return "FamilyTaskBot";
	}

	@Override
	public String getBotToken() {
		// TODO Auto-generated method stub
		return "5907128515:AAEd80M733Rxuf3GaStynwSBGqWw8hVfSWo";
	}
	public void sendText(Long who, String what){
		   SendMessage sm = SendMessage.builder()
		                    .chatId(who.toString()) //Who are we sending a message to
		                    .text(what).build();    //Message content
		   try {
		        execute(sm);                        //Actually sending the message
		   } catch (TelegramApiException e) {
		        throw new RuntimeException(e);      //Any error will be printed here
		   }
		}
	public static void main(String[] args) throws TelegramApiException {
		TelegramBotsApi api=new TelegramBotsApi(DefaultBotSession.class);
		api.registerBot(new TaskBot());
	}
	}


