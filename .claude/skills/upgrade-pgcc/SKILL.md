---
name: upgrade-pgcc
description: Upgrade the ParserGeneratorCC (com.helger:parser-generator-cc) dependency of this plugin to a new version and wire up any newly added JavaCC options. Use when asked to update/bump ParserGeneratorCC or PGCC, or to add support for a new PGCC option.
---

Target version: $ARGUMENTS (ask if not given).

1. **Find out what changed.** Read the `# News and noteworthy` section of
   `../ParserGeneratorCC/README.md` for every version between the currently referenced one and the
   target. If the sibling checkout is missing, use
   https://github.com/tulipcc/ParserGeneratorCC/blob/master/README.md instead.
   Confirm the version exists, e.g. `ls ~/.m2/repository/com/helger/parser-generator-cc/`.

2. **Bump the dependency** `com.helger:parser-generator-cc` in `pom.xml`.

3. **Check for new options.** Compare
   `../ParserGeneratorCC/src/main/java/com/helger/pgcc/parser/Options.java` (the
   `USEROPTION__*` constants and the `OptionInfo` defaults) against the options this plugin exposes.
   For each new option that applies to the `javacc` / `jjtree` / `jtb` / `jjdoc` invocations, add:
   - a field, javadoc and setter on the facade (`JavaCC.java`, `JJTree.java`, `JJDoc.java`,
     `JTB.java`) plus the argument in the method that assembles the PGCC arguments,
   - a `@Parameter` (with `property` and javadoc) in `AbstractJavaCCMojo.java` or the specific mojo,
     and the corresponding line in `AbstractJavaCCMojo.newJavaCC ()`,
   - documentation in `README.md` and, where the option list is repeated, under `src/site/apt/`.
   Options removed upstream are an incompatible change - flag them instead of silently dropping them.

4. **Match the surrounding code style** exactly (upstream codehaus style in most files) and keep the
   alphabetical/grouped ordering already used in `newJavaCC ()`.

5. **Update `README.md`** - add a bullet under the upcoming `-SNAPSHOT` version in
   `# News and noteworthy` (`vX.Y.Z - work in progress`), naming the new PGCC version and any new
   option.

6. **Verify** with `mvn clean install`, then `mvn license:format` if files were added.
