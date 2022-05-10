package com.monk.exam.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.monk.exam.common.Result;
import com.monk.exam.dto.QuestionDTO;
import com.monk.exam.entity.QuestionChoice;
import com.monk.exam.entity.QuestionFill;
import com.monk.exam.entity.QuestionJudge;
import com.monk.exam.service.QuestionChoiceService;
import com.monk.exam.service.QuestionFillService;
import com.monk.exam.service.QuestionJudgeService;
import com.monk.exam.service.QuestionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * question 题库控制层
 * 题库(选择表、判断表、填空题表)
 *
 * @author monk
 * @since 2022-04-26 16:52:43
 */
@Api(tags = "题库(选择、判断、填空题表)")
@RestController
@RequestMapping("question")
public class QuestionController {
    /**
     * 服务对象
     */
    @Resource
    private QuestionService questionService;
    @Resource
    private QuestionChoiceService questionChoiceService;
    @Resource
    private QuestionJudgeService questionJudgeService;
    @Resource
    private QuestionFillService questionFillService;

    /**
     * @description 分页查询所有数据
     * @param paramDto DTO 查询实体
     * @return 所有数据
     */
    @PostMapping("selectByCondition")
    @ApiOperation("按题库公共字段条件分页查询题库")
    public Result<?> selectQuestionChoiceByCondition(@RequestBody QuestionDTO paramDto) {
        return Result.success(questionService
                .pageMultiTable(new Page<>(paramDto.getCurrentPage(), paramDto.getPageSize()), paramDto));
    }

    /**
     * @description 新增数据/根据Id更新题库数据
     * @param paramDto DTO 实体对象
     * @return 新增/修改结果
     */
    @PostMapping
    @ApiOperation("新增/根据Id更新题库数据,type=choice/judge/fill")
    public Result<?> addQuestionChoice(@RequestBody QuestionDTO paramDto) {
        switch (paramDto.getType()) {
            case "choice":{
                QuestionChoice questionChoice = new QuestionChoice();
                BeanUtils.copyProperties(paramDto,questionChoice);
                return Result.flag(questionChoiceService.saveOrUpdate(questionChoice));
            }
            case "judge":{
                QuestionJudge questionJudge = new QuestionJudge();
                BeanUtils.copyProperties(paramDto, questionJudge);
                return Result.flag(questionJudgeService.saveOrUpdate(questionJudge));
            }
            case "fill":{
                QuestionFill questionFill = new QuestionFill();
                BeanUtils.copyProperties(paramDto, questionFill);
                return Result.flag(questionFillService.saveOrUpdate(questionFill));
            }
            default:{
                return Result.error("type设置错误");
            }
        }
    }
    
    /**
     * @description 删除单条数据
     * @param type 试题类型
     * @param id 主键
     * @return 删除结果
     */
    @DeleteMapping("{type}/{id}")
    @ApiOperation("根据id删除选择题表数据")
    public Result<?> deleteById(@PathVariable("type") String type, @PathVariable("id") Long id) {
        switch (type) {
            case "choice":{
                QuestionChoice questionChoice = new QuestionChoice();
                questionChoice.setId(id);
                return Result.flag(questionChoiceService.removeById(questionChoice));
            }
            case "judge":{
                QuestionJudge questionJudge = new QuestionJudge();
                questionJudge.setId(id);
                return Result.flag(questionJudgeService.removeById(questionJudge));
            }
            case "fill":{
                QuestionFill questionFill = new QuestionFill();
                questionFill.setId(id);
                return Result.flag(questionFillService.removeById(questionFill));
            }
            default:{
                return Result.error("type设置错误");
            }
        }
    }
    
    /**
     * @description 批量删除数据
     * @param idList 主键集合
     * @return 删除结果
     */
    @DeleteMapping("deleteByIdList")
    @ApiOperation("根据idList批量删除选择题表数据")
    public Result<?> deleteByIds(@RequestParam("ids") List<Integer> idList) {
        List<QuestionChoice> questionChoiceList = questionChoiceService.listByIds(idList);
        return Result.flag(questionChoiceService.removeBatchByIds(questionChoiceList));
    }
}