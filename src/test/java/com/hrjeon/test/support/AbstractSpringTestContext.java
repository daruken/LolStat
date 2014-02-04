package com.hrjeon.test.support;

import com.hrjeon.spring.config.DbConfig;
import com.hrjeon.spring.config.MyConfig;
import com.hrjeon.spring.config.WebMvcConfig;
import com.hrjeon.test.config.TestConfig;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by dennis on 14. 2. 4.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
@WebAppConfiguration
@ContextConfiguration(classes = {TestConfig.class, WebMvcConfig.class, DbConfig.class, MyConfig.class})
public abstract class AbstractSpringTestContext extends AbstractTransactionalJUnit4SpringContextTests {

}
