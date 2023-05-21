package telegrambot.service.currentcondition;

import telegrambot.model.util.CurrentCondition;

public interface CurrentConditionService {

    CurrentCondition getCurrentCondition();

    void updateCommandAndState(Long command, Long state);

    long getPreviousStateId();

    void updateState(long previousStateId);

    void reset();
}
