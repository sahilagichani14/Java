package Junit;

import org.junit.jupiter.api.extension.*;

public class HairSalonParameterResolver implements ParameterResolver{
    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType() == HairSalon.class;
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return new HairSalon();
    }
}
