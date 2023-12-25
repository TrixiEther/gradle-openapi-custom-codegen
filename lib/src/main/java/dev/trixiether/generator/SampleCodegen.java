package dev.trixiether.generator;
import org.openapitools.codegen.*;
import org.openapitools.codegen.languages.SpringCodegen;

import java.util.Objects;
import java.util.Optional;

public class SampleCodegen extends SpringCodegen implements CodegenConfig {

  private final String SPRING_CODEGEN_APPNAME = "OpenApiGeneratorApplication.java";
  private final String SAMPLE_APPNAME = "SampleApplication.java";

  @Override
  public String getName() {
    return "sample-codegen";
  }

  /*
    A HINT - rename the main invoker class and java file as we need!!!
   */
  @Override
  public void processOpts() {
    super.processOpts();
    Optional<SupportingFile> file = supportingFiles.stream()
            .filter(f -> Objects.equals(f.getDestinationFilename(), SPRING_CODEGEN_APPNAME))
            .findFirst();
    if (file.isPresent()) {
      SupportingFile newfile = new SupportingFile(
              file.get().getTemplateFile(),
              file.get().getFolder(),
              SAMPLE_APPNAME
      );
      supportingFiles.removeIf(f -> f.getDestinationFilename().equals(SPRING_CODEGEN_APPNAME));
      supportingFiles.add(newfile);
    }
  }
}
