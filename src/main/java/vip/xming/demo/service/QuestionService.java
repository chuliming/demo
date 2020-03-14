package vip.xming.demo.service;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.xming.demo.dto.PaginationDTO;
import vip.xming.demo.dto.QuestionDTO;
import vip.xming.demo.mapper.QuestionMapper;
import vip.xming.demo.mapper.UserMapper;
import vip.xming.demo.model.Question;
import vip.xming.demo.model.QuestionExample;
import vip.xming.demo.model.User;
import vip.xming.demo.model.UserExample;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionMapper questionMapper;


    public PaginationDTO List(Integer page, Integer size) {
        PaginationDTO paginationDTO = new PaginationDTO();
        Integer totalCount = (int) questionMapper.countByExample(new QuestionExample());
        Integer totalPage;
        if (totalCount % size == 0) {
            totalPage = totalCount / size;
        } else {
            totalPage = totalCount / size + 1;
        }
        if (page < 1) {
            page = 1;
        }
        if (page > totalPage) {
            page = totalPage;
        }
        paginationDTO.setPagination(totalPage, page);
        List<QuestionDTO> questionDTOList = new ArrayList<>();
//        size * (page - 1)
        Integer offSet = size * (page - 1);
        List<Question> questions = questionMapper.selectByExampleWithRowbounds(new QuestionExample(), new RowBounds(offSet, size));
        for (Question question : questions) {
            UserExample example = new UserExample();
            example.createCriteria().andAccountIdEqualTo(question.getCreator());
            List<User> users = userMapper.selectByExample(example);
            User user = users.get(0);
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        paginationDTO.setQuestions(questionDTOList);
        return paginationDTO;
    }

    public PaginationDTO list(String userId, Integer page, Integer size) {
        PaginationDTO paginationDTO = new PaginationDTO();
        QuestionExample questionExample = new QuestionExample();
        questionExample.createCriteria().andCreatorEqualTo(userId);
        Integer totalCount = (int) questionMapper.countByExample(questionExample);
        Integer totalPage;
        if (totalCount % size == 0) {
            totalPage = totalCount / size;
        } else {
            totalPage = totalCount / size + 1;
        }
        if (page < 1) {
            page = 1;
        }
        if (page > totalPage) {
            page = totalPage;
        }
        paginationDTO.setPagination(totalPage, page);
        List<QuestionDTO> questionDTOList = new ArrayList<>();
//        size * (page - 1)
        Integer offSet = size * (page - 1);
        QuestionExample example1 = new QuestionExample();
        example1.createCriteria().andCreatorEqualTo(userId);
        List<Question> questions = questionMapper.selectByExampleWithRowbounds(example1, new RowBounds(offSet, size));
        for (Question question : questions) {
            UserExample example = new UserExample();
            example.createCriteria().andAccountIdEqualTo(question.getCreator());
            List<User> users = userMapper.selectByExample(example);
            User user = users.get(0);
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        paginationDTO.setQuestions(questionDTOList);
        return paginationDTO;
    }

    public QuestionDTO getById(Integer id) {
        QuestionDTO questionDTO = new QuestionDTO();
        Question question = questionMapper.selectByPrimaryKey(id);
        BeanUtils.copyProperties(question, questionDTO);
        UserExample example = new UserExample();
        example.createCriteria().andAccountIdEqualTo(question.getCreator());
        List<User> users = userMapper.selectByExample(example);
        User user = users.get(0);
        questionDTO.setUser(user);
        return questionDTO;
    }

    public void createOrUpdate(Question question) {
        if (question.getId() == null) {
            //创建
            question.setGmtCreate(System.currentTimeMillis());
            question.setGmtModified(question.getGmtCreate());
            questionMapper.insert(question);
        } else {
            //更新
            question.setGmtModified(System.currentTimeMillis());
            questionMapper.updateByPrimaryKeySelective(question);
        }
    }
}
