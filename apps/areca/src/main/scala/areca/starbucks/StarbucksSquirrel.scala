package areca.starbucks

import areca.Rule
import java.nio.file.Path
import areca.squirrel.{SquirrelRecord => SquirrelRecord, SquirrelCategory}

object StarbucksSquirrel extends Rule {
  def convert(inputPath: Path, outputPath: String): Unit = {
    SquirrelRecord.export(
      output = outputPath,
      records = StarbucksRecord.fromFile(inputPath).flatMap {
        starbucks =>
          fromStarbucks(starbucks)
      }
    )
  }

  def fromStarbucks(starbucks: StarbucksRecord): Option[SquirrelRecord] = {
    Some(
      SquirrelRecord(
        date = starbucks.date,
        description = starbucks.description,
        category = SquirrelCategory.fromTextRule(starbucks.description, "areca.starbucks.category", Some("food")),
        value = starbucks.receive - starbucks.payment,
        note = ""
      )
    )
  }
}
