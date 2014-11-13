class CreateTasks < ActiveRecord::Migration
  def change
    create_table :tasks do |t|
      t.string :name
      t.timestamp :deadline

      t.timestamps
    end
  end
end
