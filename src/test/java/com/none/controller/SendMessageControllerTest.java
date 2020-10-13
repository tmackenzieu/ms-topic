package com.none.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.none.UtilTest;
import com.none.controller.utilsControllerTest.TestUtil;
import com.none.service.SendMessageService;
import com.none.service.dto.MessageDTO;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * @author Tabata Mackenzie
 */
@RunWith(MockitoJUnitRunner.class)
public class SendMessageControllerTest {

  @Rule
  public ExpectedException expectedException = ExpectedException.none();

  @InjectMocks
  SendMessageController sendMessageController;

  @Mock
  SendMessageService sendMessageService;

  MockMvc mockMvc;

  @Before
  public void setUp() {
    mockMvc = MockMvcBuilders.standaloneSetup(sendMessageController).build();
  }

  @Test
  public void imputeChangeStateTracking_Should_Return_Ok() throws Exception {
    mockMvc.perform(get("/send/message").contentType(TestUtil.APPLICATION_JSON_UTF8)
        .content(UtilTest.convertToJson(trackingOrderStatusMock()))).andExpect(status().isOk()).andDo(
        MockMvcResultHandlers.print());
  }

  private MessageDTO trackingOrderStatusMock() {
      return MessageDTO.builder().message("Hello !!").build();
  }

}
