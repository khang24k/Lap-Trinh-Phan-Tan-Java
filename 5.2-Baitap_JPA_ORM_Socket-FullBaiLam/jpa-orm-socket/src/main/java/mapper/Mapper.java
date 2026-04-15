package mapper;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import dto.ApplicationDto;
import entity.Application;

public class Mapper {

    private static final ObjectMapper MAPPER;

    static {
        MAPPER = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public static <S, T> T map (S source, Class<T> target){
        if(source == null)
            return null;
        return MAPPER.convertValue(source, target);
    }

    public static ApplicationDto map(Application application){
        ApplicationDto applicationDto = map(application, ApplicationDto.class);

        applicationDto.setJobTitle(application.getJob().getTitle());
        applicationDto.setCandidateId(application.getCandidate().getId());
        applicationDto.setCandidateName(application.getCandidate().getName());

        return applicationDto;
    }

}
