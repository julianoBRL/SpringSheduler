package com.shintaro.sheduled.interceptors;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.shintaro.sheduled.sheduled.Locker;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class CheckLocked extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		if(Locker.getInstance().isSlepping()) {
			response.setStatus(200);
			PrintWriter out = response.getWriter();
			out.write("We are doing a big process now. try againg at <place time her>");
			log.warn("SleepMode active. Ignoring request");
			return;
		}
		
		filterChain.doFilter(request, response);
		
	}

}
